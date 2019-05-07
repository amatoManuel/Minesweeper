package Minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]){
		String empty="";
		int size=0;
		int x,y;
		Scanner input= new Scanner(System.in);
		Grid minesweeper = new Grid();
		do {
			try {
				System.out.println("Inserisci numero bombe");
				size = input.nextInt();
				minesweeper.setBomb(size);
				break;
			}catch (InputMismatchException e){
				empty = input.nextLine();
				System.out.println("Errore! Hai inserito un carattere! Riprova\n"+e);
			} catch (NegativeArraySizeException e){
				System.out.println("Errore! Hai inserito un numero negativo! Riprova\n"+e);
			} catch (Exception e){
				System.out.println(e);
			}
		}while(true);
		for(int i = 0; i<minesweeper.bomb.length; i++){
			try {
			System.out.println("Inserisci "+(i+1)+"° coordinata x della bomba");
			x=input.nextInt();
			System.out.println("Inserisci "+(i+1)+"° coordinata y della bomba");
			y=input.nextInt();
			minesweeper.insertBombAt(i,x,y);
			}catch (InputMismatchException e){
				empty = input.nextLine();
				System.out.println("Errore! Hai inserito un carattere! Riprova\n"+e);
				i--;
			} catch (Exception e){
				System.out.println(e);
				i--;
			}
		}
		minesweeper.checkGrid();
		System.out.println(minesweeper);
		try {
			System.out.println("Inserisci coordinata x dove vuoi cliccare");
			x = input.nextInt();
			System.out.println("Inserisci coordinata y dove vuoi cliccare");
			y = input.nextInt();
			System.out.println(minesweeper.clickAt(x,y));
		}catch (InputMismatchException e){
			empty = input.nextLine();
			System.out.println("Errore! Hai inserito un carattere! Riprova\n"+e);
		} catch (NegativeArraySizeException | ArrayIndexOutOfBoundsException e){
			System.out.println("Errore! Hai inserito un indece fuori dalla griglia! Riprova\n"+e);
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
