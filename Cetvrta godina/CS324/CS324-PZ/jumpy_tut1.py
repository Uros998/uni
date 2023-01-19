import pygame

pygame.init()

SCREEEN_WIDTH = 400
SCREEEN_HEIGHT = 600

screen = pygame.display.set_mode((SCREEEN_WIDTH, SCREEEN_HEIGHT))
pygame.display.set_caption('Jumpy')

run = True
while  run:

