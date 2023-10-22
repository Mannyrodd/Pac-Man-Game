package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
	
	GamePanel gp;
	KeyHandler keyH;
	
	public Player(GamePanel gp, KeyHandler keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		
		x = 100;
		y = 100;
		speed = 4;
		direction = "right";
	}
	
	public void getPlayerImage() {
		try {
			
			PacUp1 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManUpMouthOpenSprite.png"));
			PacUp2 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManUpMouthSlightlyClosedSprite.png"));
			
			PacDown1 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManDownMouthOpenSprite.png"));
			PacDown2 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManDownSlightlyClosedSprite.png"));
			
			PacLeft1 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManLeftMouthOpenSprite.png"));
			PacLeft2 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManLeftMouthSlightlyClosedSprite.png"));
			
			PacRight1 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManRightMouthOpenSprite.png"));
			PacRight2 = ImageIO.read(getClass().getResourceAsStream("/Player/PacManRightMouthSlightlyClosedSprite.png"));
			
			PacClosed = ImageIO.read(getClass().getResourceAsStream("/Player/PacManMouthClosedSprite.png"));

		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
			
			if(keyH.upPressed == true) {
				direction = "up";
				y -= speed;
			}
			
			else if(keyH.downPressed == true) {
				direction = "down";
				y += speed;
			}
			
			else if(keyH.leftPressed == true) {
				direction = "left";
				x -= speed;
			}
			
			else if(keyH.rightPressed == true) {
				direction = "right";
				x += speed;
			}
			
			spriteCounter++;
			
//			Changes every n frames.
			if(spriteCounter > 1) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				
				else if(spriteNum == 2) {
					spriteNum = 3;
				}
				
				else if(spriteNum == 3) {
					spriteNum = 4;
				}
				
				else if(spriteNum == 4) {
					spriteNum = 5;
				}
				
				else if(spriteNum == 5) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		
//		g2.setColor(Color.white);
//		
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		
		switch(direction) {
		
		case "up":
			if(spriteNum == 1) {
				image = PacUp1;
			}
			
			if(spriteNum == 2) {
				image = PacUp2;
			}
			
			if(spriteNum == 3) {
				image = PacClosed;
			}
			
			if(spriteNum == 4) {
				image = PacUp2;
			}
			
			if(spriteNum == 5) {
				image = PacUp1;
			}
			break;
			
		case "down":
			if(spriteNum == 1) {
				image = PacDown1;
			}
			if(spriteNum == 2) {
				image = PacDown2;
			}
			if(spriteNum == 3) {
				image = PacClosed;
			}
			
			if(spriteNum == 4) {
				image = PacDown2;
			}
			
			if(spriteNum == 5) {
				image = PacDown1;
			}
			break;
			
		case "left":
			if(spriteNum == 1) {
				image = PacLeft1;
			}
			if(spriteNum == 2) {
				image = PacLeft2;
			}
			if(spriteNum == 3) {
				image = PacClosed;
			}
			if(spriteNum == 4) {
				image = PacLeft2;
			}
			
			if(spriteNum == 5) {
				image = PacLeft1;
			}
			break;
			
		case "right":
			if(spriteNum == 1) {
				image = PacRight1;
			}
			if(spriteNum == 2) {
				image = PacRight2;
			}
			if(spriteNum == 3) {
				image = PacClosed;
			}
			if(spriteNum == 4) {
				image = PacRight2;
			}
			
			if(spriteNum == 5) {
				image = PacRight1;
			}
			break;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

}
