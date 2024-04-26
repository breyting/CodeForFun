import turtle
import time

def draw_fractal(scale):
    if scale >= 5:  # Stop condition for the recursion     
        for _ in range(5):  # Draw a pentagon
            # Set the color based on the current time
            t = time.time() % 1  # Get the fractional part of the current time
            turtle.color((t, 1 - t, 0))            
            turtle.forward(scale)
            draw_fractal(scale / 2)  # Recursive call
            turtle.right(72)  # Angle of a pentagon

# Set up the window and its attributes
turtle.setup(800, 600)

# Set up the turtle
turtle.speed(0)
turtle.penup()
turtle.goto(-100, -50)
turtle.pendown()

draw_fractal(100)  # Draw a fractal of size 100

turtle.hideturtle()

turtle.done()