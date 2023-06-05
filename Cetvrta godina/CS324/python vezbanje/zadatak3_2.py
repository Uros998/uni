import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

def g(x):
    return np.exp(-1 * x / 2 ) * np.cos(-2 * x)

def h(x):
    return np.exp(-3*x/2) * np.sin(4*x)

x = np.linspace(0,4,501)
plt.plot(x, g(x), label='x', linestyle='-', color='red', linewidth=3)
plt.plot(x, h(x), color='black', label='g(x)', linestyle='--', linewidth=3)

plt.title('Funkcije')
plt.xlabel('x')
plt.ylabel('g(x) , h(x)')
plt.xlim(0, 4)
plt.ylim(-0.5, 1)
plt.legend()
plt.grid(True)
plt.show()

plt.savefig('funkcije1.png')

data = {'x' : x, 'g(x)' : g(x), 'h(x)' : h(x)}
df = pd.DataFrame(data)
df.to_csv('funkcije1.csv')


