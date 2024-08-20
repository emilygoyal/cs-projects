#
# ps9pr4.py (Problem Set 9, Problem 4)
#
# AI Player for use in Connect Four  
#

import random  
from ps9pr3 import *


class AIPlayer(Player):
    def __init__(self, checker, tiebreak, lookahead):
         """that constructs a new AIPlayer object
         """
         assert(checker == 'X' or checker == 'O')
         assert(tiebreak == 'LEFT' or tiebreak == 'RIGHT' or tiebreak == 'RANDOM')
         assert(lookahead >= 0)
         super().__init__(checker)
         self.tiebreak = tiebreak
         self.lookahead = lookahead
        
    def __repr__(self):
        """returns a string representing an AIPlayer object
        """
        return 'Player ' + self.checker + ' (' + self.tiebreak + ', ' + str(self.lookahead) + ')'
    
    
    def  max_score_column(self, scores):
        """takes a list scores containing a score for each column of the board, and that returns the index of the column with the maximum score.
        """
        max_score = max(scores)
        max_index = [i for i in range(len(scores)) if scores[i] == max_score]
        if self.tiebreak == 'RIGHT':
            return max_index[-1]
        elif self.tiebreak == 'LEFT':
            return max_index[0]
        elif self.tiebreak == 'RANDOM':
            return random.choice(max_index)
        
    def scores_for(self, board):
        """that takes a Board object b and determines the called AIPlayer‘s scores for the columns in b
        """
        scores = [50] * len(range(board.width))
        for col in range(board.width):
            if board.can_add_to(col) == False:
                scores[col] = -1
            elif board.is_win_for(self.opponent_checker()):
                scores[col] = 0
            elif board.is_win_for(self.checker):
                scores[col] = 100
            elif self.lookahead == 0:
                scores[col] = 50
            else:
                board.add_checker(self.checker, col)
                opponent = AIPlayer(self.opponent_checker(), self.tiebreak, self.lookahead - 1)
                scores2 = opponent.scores_for(board)
                if max(scores2) == 100:
                    scores[col] = 0
                elif max(scores2) == 0:
                    scores[col] = 100
                elif max(scores2) == 50:
                    scores[col] = 50
                board.remove_checker(col)
        return scores
                    
            
    def next_move(self, board):
        """that overrides (i.e., replaces) the next_move method that is inherited from Player
        """  
        self.num_moves += 1
        new_scores = self.scores_for(board)
        return self.max_score_column(new_scores)
    
            
         
         