#
# ps9pr2.py (Problem Set 9, Problem 2)
#
# A Connect-Four Player class 
#  

from ps9pr1 import Board

# write your class below.
class Player:

    def __init__(self, checker):
        """constructs a new Player object by initializing the following two attributes:
    
    an attribute checker – a one-character string that represents the gamepiece for the player, as specified by the parameter checker
    
    an attribute num_moves – an integer that stores how many moves the player has made so far. This attribute should be initialized to zero to signify that the Player object has not yet made any Connect Four moves.
        """
        assert(checker == 'X' or checker == 'O')
        
        self.checker = checker
        self.num_moves = 0
        
    def  __repr__(self):
        """returns a string representing a Player object. The string returned should indicate which checker the Player object is using
        """
        s = ''
        s +='Player ' + self.checker
        return s
    
    def opponent_checker(self):
        """returns a one-character string representing the checker of the Player object’s opponent. The method may assume that the calling Player object has a checker attribute that is either 'X' or 'O'
        """
        if self.checker == 'O':
            return 'X'
        else:
            return 'O'
        
    def next_move(self, b):
        """accepts a Board object b as a parameter and returns the column where the player wants to make the next move
        """
        i = int(input('Enter a column: '))
        while(i < 0 or i >= b.width):
            print('Try again!')
            i = int(input('Enter a column: '))
        self.num_moves += 1
        return i