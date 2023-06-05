import numpy as np
import matplotlib.pyplot as plt
import pandas as pd


def g(x):
    return np.exp(-1/5*x) * np.cos(5*x)

def h(x):
    return np.exp(-1/2*x) * np.sin(2*x)

x = np.linspace(0, 10, 1001)
plt.plot(x, g(x), color='blue', label="$g_x$", linewidth=2)
plt.plot(x, h(x), color='red', linestyle='dotted')

plt.title('Funkcije $g_x$ i $h_x$')
plt.xlabel('x')
plt.ylabel('Funkcije')
plt.xlim(0, 10)
plt.ylim(-1,1)
plt.grid()
plt.legend()
plt.show()

plt.savefig('funkcije.png')

data = {'x' : x, 'g(x)' : g(x), 'h(x)' : h(x)}
df = pd.DataFrame(data)
df.to_csv('funkcije.csv', index=False)
