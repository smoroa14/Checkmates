package beans;

public abstract class Figur {

  public enum FigurTyp{
    BAUER
  }

  private FigurTyp typ;

  public Figur(FigurTyp typ) {
    this.typ = typ;
  }

  public FigurTyp getTyp() {
    return typ;
  }

  public void setTyp(FigurTyp typ) {
    this.typ = typ;
  }
}
