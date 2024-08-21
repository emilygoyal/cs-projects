# CONNECT FOUR PROJECT
I developed a Connect Four game in Python with an interactive AI opponent. The game features a flexible Board class that handles adding and removing checkers, checking for wins, and managing the game state. I created a Player class for human players and an AIPlayer class that uses a strategic algorithm with adjustable difficulty. The gameplay alternates between human and AI moves, with the AI making decisions based on board evaluation. This project showcases my skills in Python programming and object-oriented design, with a focus on creating engaging, interactive experiences.

How to run the code:

Step 1: Create a human player and an AI player:

p1 = Player('X')  # Human player
p2 = AIPlayer('O', 'LEFT', 2)  # AI player with LEFT tiebreak and 2-move lookahead ((tiebreak can be 'LEFT', 'RIGHT', or 'RANDOM'),(lookahead can be any number of moves you want the AI player to antipacte during the game))


Step 2: Start the game:

final_board = connect_four(p1, p2)


Step 3: Print the final board state:

print(final_board)

# PHOTO EDITING PROJECT
I developed an image processing tool in Python to manipulate images using custom functions. The tool includes functionalities to convert images to black and white, flip images upside down, create mirror reflections, and shrink images by half. Implemented key functions like bw() for black-and-white conversion based on brightness thresholds, and upside_down() for image flipping. I leveraged 2D lists to represent and manipulate pixel data, ensuring efficient processing of images. 


How to run the code:

Step 1: Load the image into a 2D list of pixels:

pixels = load_pixels('spam.png') (this is one of many you can try from the 'Photo Editing' folder)


Step 2: Convert the image to black and white with a threshold of 128:

bw_pixels = bw(pixels, 128) (this is one of many functions you can apply to the image to edit it)


Step 3: Save the black and white image:

save_pixels(upside_down_pixels, 'example_upside_down_bw.png')

# EIGHT PUZZLE SOLVER
I developed an Eight Puzzle solver using various state-space search algorithms, including Breadth-First Search (BFS), Depth-First Search (DFS), Greedy Search, and A* Search. It features classes to represent the puzzle board, track states, and measure the time taken to find solutions. The solver efficiently navigates the puzzle's state space to find the optimal sequence of moves, using heuristics to prioritize promising paths. The main function, eight_puzzle, allows users to specify the algorithm and parameters, providing a flexible tool for solving and analyzing the Eight Puzzle problem.

How to run the code:

Step 1: Create the Board object

initial_board = Board('142358607')


Step 2: Create the initial State object

initial_state = State(initial_board, None, 'init')


Step 3: Solve the puzzle using the A* algorithm with heuristic h1

eight_puzzle('142358607', 'A*', 'h1')((algoriths can be: 'BFS', 'DFS', 'Greedy', 'A*')(hueristic functions can be: 'h0', 'h1', 'h2')) 
