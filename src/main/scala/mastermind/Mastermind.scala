import scala.util.Random
import scala.io.StdIn.readLine

/** *****************************************************************************
  * Representing a game
  *
  * We will represent the board as a string of four characters. Each character
  * will be one of the following: B = Blue, Y = Yellow, R = Red, G = Green
  */
type Color = Char
type Board = String
val validColors = List('B', 'Y', 'R', 'G')

/** Get a random color from the list of valid colors */
def getRandomColor(): Color =
  val index = Random.nextInt(4)
  return validColors(index)

/** Given four colors, make a board from them */
def makeBoardFromColors(c1: Color, c2: Color, c3: Color, c4: Color): Board =
  return s"${c1}${c2}${c3}${c4}"

/** Create a random board */
def getRandomBoard(): Board =
  val board = makeBoardFromColors(
    getRandomColor(),
    getRandomColor(),
    getRandomColor(),
    getRandomColor())
  return board

/** Play one round of the game */
def playRound(board: Board): (Int, Int) =
   print("Enter a guess for spot 1: ")
   val charGuess1: Char = scala.io.StdIn.readChar()
   var guess1 = charGuess1.asInstanceOf[Color]; //Casting

   print("Enter a guess for spot 2: ")
   val charGuess2: Char = scala.io.StdIn.readChar()
   var guess2 = charGuess2.asInstanceOf[Color]; //Casting

   print("Enter a guess for spot 3: ")
   val charGuess3: Char = scala.io.StdIn.readChar()
   var guess3 = charGuess3.asInstanceOf[Color]; //Casting

   print("Enter a guess for spot 4: ")
   val charGuess4: Char = scala.io.StdIn.readChar()
   var guess4 = charGuess4.asInstanceOf[Color]; //Casting
   
   val guessBoard = makeBoardFromColors(guess1, guess2, guess3, guess4)
   return scoreGuess(board, guessBoard)
/** Score a guess
  *
  * A score is a tuple of two integers. The first integer is the number of
  * correct positions, and the second integer is the number of remaining correct
  * colors.
  */
def scoreGuess(board: Board, guess: Board): (Int, Int) = {

  // The initial score is (0, 0)
  var correctPositions = 0
  var correctColors = 0

  // Get the unique colors on the board
  val boardColors = board.toSet

  // Check each guess position against the corresponding board position
  // or (if there is not a match at that position) against the remainder of
  // the board.
  for (i <- 0 to 3) {
    if (guess(i) == board(i)) {
      correctPositions += 1
    } else if (boardColors.contains(guess(i))) {
      correctColors += 1
    }
  }

  (correctPositions, correctColors)
}

/** *****************************************************************************
  * Main program
  */

// When true, the program will print out the board at the start of the game
val DEBUG = true

@main
def mastermind() = {

  // Create a new board
  val board = getRandomBoard()

  if (DEBUG) {
    println(s"[DEBUG] The board is $board")
  }

  // Play rounds until the user guesses the board
  var score = (0, 0)
  while (score != (4, 0)) {
    score = playRound(board)
    val (correctPlace, correctColor) = score
    println(s"$correctPlace color(s) are in the correct place.")
    println(s"$correctColor color(s) are correct but in the wrong place.\n")
  }

  // End the game
  println(s"Congratulations! You figured out the board was $board")
}
