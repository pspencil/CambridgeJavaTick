package uk.ac.cam.sp794.oopjava.tick2star;
import uk.ac.cam.acr31.life.World;
import java.io.Writer;
import java.awt.Graphics;
import java.io.PrintWriter;


public class ArrayWorld extends WorldImpl {
        private boolean[][] cells;
        private int population;
        public ArrayWorld(int width, int height){
                super(width,height);
                cells = new boolean[height][width];
        }
        public ArrayWorld(ArrayWorld w){
                super(w);
                cells = new boolean[getHeight()][getWidth()];
        }
        public boolean getCell (int col, int row) {
                if(row<0||col<0|| row>getHeight()-1|| col>getWidth()-1)
                        return false;
                return cells[row][col];
        }
        @Override 
        public int getPopulation(){
                int pop = 0;
                for(boolean[] row : cells)
                        for(boolean cell : row)
                                if(cell)
                                        pop++;
                return pop;

        }



        public void setCell(int col, int row, boolean alive) {cells[row][col]=alive;}
        protected ArrayWorld nextGeneration(){
                ArrayWorld world = new ArrayWorld(this);
                for(int i=0;i<getHeight();i++)
                        for(int j=0;j<getWidth();j++){
                                world.setCell(j,i,computeCell(j,i));
                        }
                return world;
        }
}
