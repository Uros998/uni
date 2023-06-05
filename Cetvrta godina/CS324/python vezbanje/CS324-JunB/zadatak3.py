import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

def g(x):
    return np.exp(-1*x/5)*np.cos(5*x)

def h(x):
    return np.exp(-1*x/2)*np.sin(2*x)

x = np.linspace(0, 5 , 501)
plt.plot(x, g(x), label='g(x)', linestyle='--', color='black', linewidth=2)
plt.plot(x, h(x), label='h(x)', linestyle='-', color='red', linewidth=2)

plt.title('Trigonometrijske funkcije')
plt.xlabel('x')
plt.xlim(0, 5)
plt.ylabel('funkcije')
plt.ylim(-1, 1)
plt.legend()
plt.grid(True)
plt.show()
plt.savefig("funkcije.png")

data = {'x' : x, 'g(x)' : g(x), 'h(x)' : h(x)}
df = pd.DataFrame(data)
df.to_csv('funkcije.csv', index=False)
