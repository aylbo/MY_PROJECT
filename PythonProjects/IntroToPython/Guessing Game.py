import random

keep_playing = "y"

while keep_playing == "y":
    print("Game Start")
    hidden_number = random.randint(1,100)
    user_guess = 0

    while not user_guess == hidden_number:
        user_guess = int(input("Guess a number: "))
        if user_guess > hidden_number:
	    print ("Too high!")
        elif user_guess < hidden_number:
            print("Too low!")
        else:
            print("That's right")
     
    keep_playing = input("Play again (y for yes, n for no)?")
