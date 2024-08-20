# CONNECT FOUR PROJECT
I developed a Connect Four game in Python with an interactive AI opponent. The game features a flexible Board class that handles adding and removing checkers, checking for wins, and managing the game state. I created a Player class for human players and an AIPlayer class that uses a strategic algorithm with adjustable difficulty. The gameplay alternates between human and AI moves, with the AI making decisions based on board evaluation. This project showcases my skills in Python programming and object-oriented design, with a focus on creating engaging, interactive experiences.

How to run the code:

Create a human player and an AI player:

p1 = Player('X')  # Human player
p2 = AIPlayer('O', 'LEFT', 2)  # AI player with LEFT tiebreak and 2-move lookahead ((tiebreak can be 'LEFT', 'RIGHT', or 'RANDOM'),(lookahead can be any number of moves you want the AI player to antipacte during the game))


Start the game:

final_board = connect_four(p1, p2)


Print the final board state:

print(final_board)

# PHOTO EDITING PROJECT
I developed an image processing tool in Python to manipulate images using custom functions. The tool includes functionalities to convert images to black and white, flip images upside down, create mirror reflections, and shrink images by half. Implemented key functions like bw() for black-and-white conversion based on brightness thresholds, and upside_down() for image flipping. I leveraged 2D lists to represent and manipulate pixel data, ensuring efficient processing of images. 


How to run the code:

Load the image into a 2D list of pixels:

pixels = load_pixels('spam.png') (this is one of many you can try from the 'Photo Editing' folder)


Convert the image to black and white with a threshold of 128:

bw_pixels = bw(pixels, 128) (this is one of many functions you can apply to the image to edit it)


Save the black and white image:

save_pixels(upside_down_pixels, 'example_upside_down_bw.png')
