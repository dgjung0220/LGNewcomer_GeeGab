package DBManager.Web.vo;

import java.io.Serializable;

public class Menu implements Serializable {
	private int numOfMenu;
	private String nameOfMenu;
	private int calOfMenu;
	private byte[] pictureOfMenu;
	
	public Menu(String nameOfMenu, int calOfMenu, byte[] pictureOfMenu) {
		this.nameOfMenu = nameOfMenu;
		this.calOfMenu = calOfMenu;
		this.pictureOfMenu = pictureOfMenu;
	}
	
	public int getNumOfMenu() {
		return numOfMenu;
	}
	public void setNumOfMenu(int numOfMenu) {
		this.numOfMenu = numOfMenu;
	}
	public String getNameOfMenu() {
		return nameOfMenu;
	}
	public void setNameOfMenu(String nameOfMenu) {
		this.nameOfMenu = nameOfMenu;
	}
	public int getCalOfMenu() {
		return calOfMenu;
	}
	public void setCalOfMenu(int calOfMenu) {
		this.calOfMenu = calOfMenu;
	}
	public byte[] getPictureOfMenu() {
		return pictureOfMenu;
	}
	public void setPictureOfMenu(byte[] pictureOfMenu) {
		this.pictureOfMenu = pictureOfMenu;
	}
}
