import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_200605b extends PApplet {

ArrayList<Particle>particles = new ArrayList<Particle>();
public void setup() {
  
  background(200);
}
public void draw() {
  background(200);
  for (int i = 0; i<5; i++) {
    particles.add(new TriParticle(mouseX, mouseY, 20));
    particles.add(new SquareParticle(mouseX,mouseY, 20));
  }
  ArrayList<Particle>particlesToBeRemoved = new ArrayList<Particle>();
  for (Particle  p : particles ) {
    if (p.size <= 0) {
      particlesToBeRemoved.add(p);
    }
    p.update();
    p.draw();
  }
  for (Particle p : particlesToBeRemoved) {
    particles.remove(p);
  }
}
class Particle {
  PVector pos;
  float size;
  PVector speed;
  PVector gravity;
  Particle() {
    pos = new PVector(200, 500);
    size = 10;
  }
  Particle(float x, float y, float s) {
    pos = new PVector (x, y);
    size = s;
    speed = new PVector();
    speed.x = random(-10, 10);
    speed.y = random(-10, 10);
    gravity = new PVector(0, 0);
  }
  public void draw() {
    fill(0, 50);
    noStroke();
    circle(pos.x, pos.y, size);
  }
  public void update() {
    PVector accel = new PVector();
    size += -.75f;
    pos.add(speed);
    accel.add(gravity);
    speed.add(accel);
    speed.mult(0.8f);
  }
}

class SquareParticle extends Particle {
  SquareParticle(float x, float y, float s) {
    super(x, y, s);
  }
  public void draw() {
    fill(0, 50);
    noStroke();
    rect(pos.x, pos.y, 10, 10);
  }
}
class TriParticle extends Particle {
  float rotation = 0;
  TriParticle(float x, float y, float s) {
    super(x, y, s);
    rotation = random(100);
  }
  public void draw() {
    fill(255, 0, 0, 50);
    noStroke();
    pushMatrix();
    translate(pos.x, pos.y);
    rotate(rotation+frameCount/100.0f);
    triangle(0, 0, 10, 0, 5, -5*sqrt(3));
    popMatrix();
  }
}
  public void settings() {  size(400, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "sketch_200605b" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
