I developed a Connect Four game in Python with an interactive AI opponent. The game features a flexible Board class that handles adding and removing checkers, checking for wins, and managing the game state. I created a Player class for human players and an AIPlayer class that uses a strategic algorithm with adjustable difficulty. The gameplay alternates between human and AI moves, with the AI making decisions based on board evaluation. This project showcases my skills in Python programming and object-oriented design, with a focus on creating engaging, interactive experiences.

How to run the code:
# Create a human player and an AI player
p1 = Player('X')  # Human player
p2 = AIPlayer('O', 'LEFT', 2)  # AI player with LEFT tiebreak and 2-move lookahead ((tiebreak can be 'LEFT', 'RIGHT', or 'RANDOM'),(lookahead can be any number of moves you want the AI player to antipacte during the game))

# Start the game
final_board = connect_four(p1, p2)

# Print the final board state
print(final_board)
