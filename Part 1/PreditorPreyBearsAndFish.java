
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
   static final int    WIDTH          = 60;
   static final int    HEIGHT         = 20;
   static final int    STARTING_FISH  = 15;
   static final double CHANCE_TO_MOVE = 0.50; // 50% chance of moving.

   Animal[][] ecoArray;

   SecureRandom random = new SecureRandom();

   public PreditorPreyBearsAndFish()
   {
      ecoArray = new  Animal[WIDTH][HEIGHT];

      int fishCount = 0;

      // Add Fish to random locations in our ecosystem:
      while (fishCount < STARTING_FISH)
      {
         // Get a random coordinate: x, y - and see if that location is vacant / null.
         int x = random.nextInt (WIDTH);  // 0 <= x < WIDTH
         int y = random.nextInt (HEIGHT); // 0 <= y < HEIGHT

         if (ecoArray[x][y] == null)
         {
            ecoArray[x][y] = new Fish();
            fishCount++;
         }
      }
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
         }
         outStr += "\n";
      }

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