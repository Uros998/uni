import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

def g(x):
    return np.exp(-1 * x / 2 ) * np.cos(-2 * x)

x = np.linspace(0, 4, 501)
plt.plot(x, g(x), label='x', linestyle='-', color='red', linewidth=3)

plt.title('Funkcija')
plt.xlabel('$x$')
plt.ylabel('$g(x)$')
plt.xlim(0, 4)
plt.ylim(-0.5, 1)
plt.legend()
plt.grid()
plt.show()

plt.savefig('funkcija.png')

data = {'x' : x, "g(x)" : g(x)}
df = pd.DataFrame(data)
df.to_csv('funkcije.csv')