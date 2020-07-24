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
  void draw() {
    fill(0, 50);
    noStroke();
    circle(pos.x, pos.y, size);
  }
  void update() {
    PVector accel = new PVector();
    size += -.75;
    pos.add(speed);
    accel.add(gravity);
    speed.add(accel);
    speed.mult(0.8);
  }
}

class SquareParticle extends Particle {
  SquareParticle(float x, float y, float s) {
    super(x, y, s);
  }
  void draw() {
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
  void draw() {
    fill(255, 0, 0, 50);
    noStroke();
    pushMatrix();
    translate(pos.x, pos.y);
    rotate(rotation+frameCount/100.0);
    triangle(0, 0, 40, 5, 5, -5*sqrt(3));
    popMatrix();
  }
}
