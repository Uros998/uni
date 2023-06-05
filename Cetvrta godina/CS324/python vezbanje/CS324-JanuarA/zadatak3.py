import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
import csv

def g(x):
    return np.exp(-1 * x / 5) * np.cos(5 * x)

def h(x):
    return np.exp(-1 * x / 2) * np.sin(2 * x)

x = np.linspace(0 , 5, 501)
plt.plot(x, g(x), color= 'black', label='g(x)', linestyle= '--')
plt.plot(x, h(x), color= 'red', label='h(x)', linewidth= 2)

plt.title('Trigonometrijske funkcije')
plt.xlabel('$x$')
plt.ylabel('$funkcije$')
plt.xlim(0,5)
plt.ylim(-1,1)
plt.grid()
plt.legend()
plt.show()

plt.savefig('funkcije.png')

# Cuvanje vrednosti x, g(x) i h(x) u CSV datoteku
data = {'x': x, 'g(x)': g(x), 'h(x)': h(x)}
df = pd.DataFrame(data)
df.to_csv('funkcije.csv', index=False)