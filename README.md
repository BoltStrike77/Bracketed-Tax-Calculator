# Small Business Bracketed Tax Calculator

## What inspired me

Recently, as part of the growing up process, I learned about taxes. Taxes are complicated and messy to complete. That's why, for the topic of helping small businesses, I decided to help those businesses do their taxes. Maybe my program would help small businesses, already overburdened with the pandemic and shortages, and take a little load of their plate.

## What I learned

As part of writing this program, I learned a ton about how both complex coding with taxes are, and how useful try/catch is. I used try/catch to, instead of returning exceptions, ask the user to try their input again (maybe it was a mistype). After the second try, however, it's exception time. I also learned the different ways to use JOptionPanes as a better way to interact with the user.

## How I built my project

I started by dividing my work into about 3 methods that would do the majority of the work: setBrackets(), which would do the input; calculateTax(), which would, as the name suggests, calculate tax; and printResults(), which would display the results. As I kept coding, however, I realized that some "simple" tasks may need to be relegated to a new method for simplicity's sake. I had a new method for calculating the amounts of money to do tax on, and another method to calculate average tax. These new methods greatly increased the readability of my program and allowed me to better understand my own code.

## Challenges I faced

As a programmer, I face bugs countless times. This program in particular, though, might have been my personal record. From string formatting errors (how is one going to memorize those flags?), to a simple, yet decieving line of code about ArrayLists. For the string formatting errors, I consulted Oracle's helpful Java docs. For the ArrayList problem, I realized that starting my loop index at 1, means that for the code that was meant to be 1 index before the previous (ex. i-1), it had to be i-2.

## What's next

I hope to introduce this program to a larger group of individuals, who could maybe use this software for their own needs. However, I understand that applications like TurboTax already dominate the market, but maybe someone would prefer this, actually knowing how to do it by looking at the code? 
