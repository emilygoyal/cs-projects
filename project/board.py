#
# board.py (Final project)
#
# A Board class for the Eight Puzzle
#
# name: 
# email:
#
# If you worked with a partner, put their contact info below:
# partner's name:
# partner's email:
#

# a 2-D list that corresponds to the tiles in the goal state
GOAL_TILES = [['0', '1', '2'],
              ['3', '4', '5'],
              ['6', '7', '8']]

class Board:
    """ A class for objects that represent an Eight Puzzle board.
    """
    def __init__(self, digitstr):
        """ a constructor for a Board object whose configuration
            is specified by the input digitstr
            input: digitstr is a permutation of the digits 0-9
        """
        # check that digitstr is 9-character string
        # containing all digits from 0-9
        assert(len(digitstr) == 9)
        for x in range(9):
            assert(str(x) in digitstr)

        self.tiles = [[''] * 3 for x in range(3)]
        self.blank_r = -1
        self.blank_c = -1

        # Put your code for the rest of __init__ below.
        # Do *NOT* remove our code above.
        for r in range(3):
            for c in range(3):
                self.tiles[r][c] = digitstr[3*r + c]
                if self.tiles[r][c] == '0':
                    self.blank_r = r
                    self.blank_c = c

    ### Add your other method definitions below. ###
    def __repr__(self):
        """returns a string representation of a Board object
        """
        board = ''
        for r in self.tiles:
            for tile in r:
                if tile =='0':
                    board += '_ '
                else:
                    board += tile + ' '
            board += '\n'
        return board
    
    def move_blank(self, direction):
        """that takes as input a string direction that specifies the direction in which the blank should move, and that attempts to modify the contents of the called Board object accordingly
        """
        new_blank_r = self.blank_r
        new_blank_c = self.blank_c

        if direction == 'up':
            new_blank_r -= 1
        elif direction == 'down':
            new_blank_r += 1
        elif direction == 'right':
            new_blank_c += 1
        elif direction == 'left':
            new_blank_c -= 1
        else:
            return False
        
        if new_blank_c not in range(3) or new_blank_r not in range(3):
            return False
        else:
            #switching values
            self.tiles[self.blank_r][self.blank_c] = self.tiles[new_blank_r][new_blank_c]
            self.tiles[new_blank_r][new_blank_c] = '0'
            self.blank_r = new_blank_r
            self.blank_c = new_blank_c
            return True
        
    def digit_string(self):
        """creates and returns a string of digits that corresponds to the 
        current contents of the called Board object’s tiles attribute"""
        count = ''
        for r in self.tiles:
            for tile in r:
                count += tile
        return count
    
    def copy(self):
        """returns a newly-constructed Board object that is a deep copy 
        of the called object (i.e., of the object represented by self)"""
        digit_string = self.digit_string()
        new = Board(digit_string)
        return new
    
    def num_misplaced(self):
        """returns the number of tiles in the called Board object 
        that are not where they should be in the goal state"""
        goal = [['0', '1', '2'], ['3', '4', '5'], ['6', '7', '8']]
        count = 0
        for r in range(3):
            for c in range(3):
                if self.tiles[r][c] != '0' and self.tiles[r][c] != goal[r][c]:
                    count += 1
        return count
    
    def __eq__(self, other):
        """return True if the called object (self) and the argument (other)
        have the same values for the tiles attribute, and False otherwise"""
        if self.tiles == other.tiles:
            return True
        else:
            return False
        
    def num_misplaced2(self):
        """returns the number of tiles in the called Board object 
        that are not where they should be in the goal state"""
        goal = [['0', '0', '0'], ['1', '1', '1'], ['2', '2', '2']]
        count = 0
        for r in range(3):
            for c in range(3):
                if (self.tiles[r][c] in '012') and goal[r][c] != '0':
                    count += 1
                elif (self.tiles[r][c] in '345') and goal[r][c] != '1':
                    count += 1
                elif (self.tiles[r][c] in '678') and goal[r][c] != '2':
                    count += 1
        return count
        
        
    
            
    