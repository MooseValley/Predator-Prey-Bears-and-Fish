/*
 Author: Moose OMalley
 Source: PreditorPreyBearsAndFish.java
Descrtn: Simple simulation of Preditor-Prey - Bears and Fish.
*/
import java.security.SecureRandom;
import java.util.Scanner;
import javax.swing.Timer;


class Animal
{
}

class Fish extends Animal
{
}

class Bear extends Animal
{
}

public class PreditorPreyBearsAndFish
{
   public static final int    WIDTH          = 60;
   public static final int    HEIGHT         = 20;
   public static final int    STARTING_FISH  = 45;
   public static final int    STARTING_BEARS = 40;
   public static final double CHANCE_TO_MOVE = 0.50; // 50% chance of moving.

   private SecureRandom random = new SecureRandom();

   private Animal[][] ecoArray;
   private int fishCount = 0;
   private int bearCount = 0;


   public PreditorPreyBearsAndFish()
   {
      ecoArray = new  Animal[WIDTH][HEIGHT];

      // Add Fish to random locations in our ecosystem:
      while (fishCount < STARTING_FISH)
      {
         fishCount += addNewAnimal (new Fish() );
      }

      // Add Bear to random locations in our ecosystem:
      while (bearCount < STARTING_BEARS)
      {
         bearCount += addNewAnimal (new Bear() );
      }
   }

   // fishCount += addNewAnimal (new Fish() );
   private int addNewAnimal(Animal animal)
   {
      int addCount = 0;

      int totalCellsSoFar = fishCount + bearCount;

      if (totalCellsSoFar < WIDTH * HEIGHT)
      {
         // Add an animal to a random location in our ecosystem array:
         while (addCount == 0)
         {
            // Get a random coordinate: x, y - and see if that location is vacant / null.
            int x = random.nextInt (WIDTH);  // 0 <= x < WIDTH
            int y = random.nextInt (HEIGHT); // 0 <= y < HEIGHT

            if (ecoArray[x][y] == null)
            {
               ecoArray[x][y] = animal;
               addCount++;
            }
         }
      }

      return addCount;
   }

   @Override
   public String toString()
   {
      String outStr = "";

      for (int y = 0; y < HEIGHT; y++)
      {
         for (int x = 0; x < WIDTH; x++)
         {
            if (ecoArray[x][y] == null)
            {
               outStr += ".";
            }
            else if (ecoArray[x][y] instanceof Fish)
            {
               outStr += "F";
            }
            else if (ecoArray[x][y] instanceof Bear)
            {
               outStr += "B";
            }
         }
         outStr += "\n";
      }

      outStr += "Fish: " + fishCount + "      Bears: " + bearCount;

      return outStr;
   }

   public void move ()
   {
      // For each Fish, Bear, etc ...
      // Move them up to 1 cell vertically / horizontally at random.
      for (int y = 0; y < HEIGHT; y++)
      {
         for (int x = 0; x < WIDTH; x++)
         {
            if (ecoArray[x][y] != null)
            {
               double chance = random.nextDouble();

               if (chance < CHANCE_TO_MOVE)
               {
                  int xChange = random.nextInt (3) - 1; // -1, 0 , +1
                  int yChange = random.nextInt (3) - 1; // -1, 0 , +1

                  int xNew = x + xChange;
                  int yNew = y + yChange;

                  // TODO: Collisions

                  /*
                  if ((xChange != 0) && (xNew >= 0) && (xNew < WIDTH) &&
                      (ecoArray[xNew][y] == null))
                  {
                     ecoArray[xNew][y] = ecoArray[x][y];
                     ecoArray[x][y]    = null;
                  }

                  if ((yChange != 0) && (yNew >= 0) && (yNew < HEIGHT) &&
                      (ecoArray[x][yNew] == null))
                  {
                     ecoArray[x][yNew] = ecoArray[x][y];
                     ecoArray[x][y]    = null;
                  }
                  */

                  boolean xCanMove = false;
                  boolean yCanMove = false;

                  if ((xChange != 0) && (xNew >= 0) && (xNew < WIDTH) )
                  {
                     xCanMove = true;
                  }

                  if ((yChange != 0) && (yNew >= 0) && (yNew < HEIGHT) )
                  {
                     yCanMove = true;
                  }

                  if ((xCanMove == true) || (yCanMove == true))
                  {
                     int xFinal = x;
                     int yFinal = y;

                     if (xCanMove == true)
                        xFinal = xNew;

                     if (yCanMove == true)
                        yFinal = yNew;


                     if (ecoArray[xFinal][yFinal] == null)
                     {
                        ecoArray[xFinal][yFinal] = ecoArray[x][y];
                        ecoArray[x][y]           = null;
                     }
                     else if (ecoArray[x][y].getClass() == ecoArray[xFinal][yFinal].getClass() )
                     {
                        // Create baby fish or bear or ...
                        if (ecoArray[x][y].getClass().getName().equals ("Fish") == true)
                           fishCount += addNewAnimal (new Fish() );

                        if (ecoArray[x][y].getClass().getName().equals ("Bear") == true)
                           bearCount += addNewAnimal (new Bear() );

                     }
                     else if (ecoArray[x][y].getClass() != ecoArray[xFinal][yFinal].getClass() )
                     {
                        // If Bear is moving onto a Fish - eat the fish
                        //if (ecoArray[x][y].getClass() == Fish)
                        //   delete it
                        //if (ecoArray[xFinal][yFinal].getClass() == Fish)
                        //   delete it
                        if (ecoArray[x][y].getClass().getName().equals ("Fish") == true)
                        {
                           if (fishCount > 0)
                           {
                              ecoArray[x][y] = null;
                              fishCount--;
                           }
                        }

                        if (ecoArray[xFinal][yFinal].getClass().getName().equals ("Fish") == true)
                        {
                           if (fishCount > 0)
                           {
                              ecoArray[xFinal][yFinal] = ecoArray[x][y];
                              fishCount--;
                           }
                        }
                     }

               }


               }

            }
         }

      }

   }

   public void moveAndDisplay()
   {
      System.out.println (this);

      move();
   }

   public static void main (String[] args)
   {
      PreditorPreyBearsAndFish pp = new PreditorPreyBearsAndFish ();
      Scanner keyboard = new Scanner (System.in);

      /*
      for (int k = 0; k < 25; k++)
      {
         System.out.println (pp );
         pp.move();

         keyboard.nextLine();
      }
      */

      Timer t = new Timer (500, event -> pp.moveAndDisplay() );
      t.start();

      keyboard.nextLine();
   }


}