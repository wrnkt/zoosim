## zoosim ##

#### Determining Death
*Component 1*:
a ratio representing chance of death as a function of age,
reaching a 100% chance by a certain age
this is likely best represented by a function in the form:
`f(x) = x^5 + x^3`
and its inverse (or some combination):
`x = f(x)`

*Component 2*:
a dice roll that occurs based on an oopsDiedRisk variable.
oopsDiedRisk is determined by: current activity, age, parents
