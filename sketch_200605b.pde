ArrayList<Particle>particles = new ArrayList<Particle>();
void setup() {
  size(400, 400);
  background(200);
}
void draw() {
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
