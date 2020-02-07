In this file you should include:

Any information you think we should know about your submission
* Is there anything that doesn't work? Why?
  N/A
* Is there anything that you did that you feel might be unclear? Explain it here.
  N/A

A description of the creative portion of the assignment
* Describe your feature
  For the creative portion of the assignment, I implemented the ability to delete an item from the list. To delete, the user  
  will press the "X" button, which will then remove the entire line and add the calories back into the remaining amount. 
  
* Why did you choose this feature?
  I chose this feature, because I think it is very useful and something I and many others would definitely use in a calorie 
  counting app.
  
* How did you implement it?
  I basically implemented the opposite of adding food items to the list. I made use of the FoodListAdapter. I thought it would   be harder to deal with the variables and grabbing the right one, but it was easily handled for me. I basically would grab 
  the food and calorie amount associated with the "X" button that is clicked, remove it from the ArrayList, which would then 
  notify the FoodListAdapter of the updates, and the changes would be made. In addition, I made sure to change the color back 
  to black if the calories amount went above 0;


