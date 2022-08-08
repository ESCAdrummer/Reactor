# Calculation of an ideal Reactor

# I used to be a Chemical Reaction Engineering professor in a past life and always had the idea to 
# build this with a GUI for academic purposes and to show the interactions between parameters. I 
# started to learn Java and I see the potential for OOP for scientific and teaching purposes.

# For the moment, only one basic reaction with 4 components is considered. However, you can play 
# with the stoichiometric coefficients, initial flowrates and kinetic coefficients and learn
# the interactions between these parameters.

# For example, there is a single equilibrium reaction. To simulate in one direction or the other,
# the Kd or Ki can be entered 0. You can evaluate the effect of having more or less of one of the 
# reactants. What would happen if you have both Kd and Ki equal? What is the predicted conversion?

# The next version will include a selector for a CSTR (Continuous-Stirred Tank Reactor) and the PFR 
# (Plug-Flow Reactor), which are the two main ideal continuous reactors.

# PFR is currently solved using the Apache commons Math library with a ODE solver. CSTR should be
# solved using a numeric method for implicit equations such as Newton-Raphson.

# Future versions of this should also be able to introduce the energy balance equation to estimate 
# the temperature and eventually let the user choose how many reactions and ask for all the required 
# input.

# Enjoy and shoot me an email if you ever have any questions.