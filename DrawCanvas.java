package drawer;

import command.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리기 색      
    private Color color;    
    // 그리기 점의 반경    
    private int radius;     
    // 이력
    private MacroCommand history;
    // 생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
        init();                             
    }
    // 이력전체를 다시 그리기
    public void paint(Graphics g) {
        history.execute();
    }
    // 초기화                           
    public void init() {                    
        color = Color.red;                  
        radius = 6;                         
    }                                       
    // 그리기
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    public void setColor(Color color) {     
        this.color = color;                 
    }                                       
}
