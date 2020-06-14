package primitives;

public class Material 
{
private double ks;
private double kd;
private double n;
private double kt;
private double kr;
//***************** Constructors ********************** //
public Material() 
{
	super();
	this.ks = 1;
	this.kd = 1;
	this.n = 1;
	this.kt = 0;
	this.kr = 0;

}
public Material(double ks, double kd, double n) {
	super();
	this.ks = ks;
	this.kd = kd;
	this.n = n;

	
}
public Material(double ks, double kd, double n, double kt, double kr) {
	super();
	this.ks = ks;
	this.kd = kd;
	this.n = n;
	this.kt = kt;
	this.kr = kr;

	
}
public Material(Material m) {
	super();
	this.ks = m.ks;
	this.kd = m.kd;
	this.n = m.n;
	this.kt = m.kt;
	this.kr = m.kr;

}
// ***************** Getters/Setters ********************** // 
public double getKs() {
	return ks;
}
public void setKs(double ks) {
	this.ks = ks;
}
public double getKd() {
	return kd;
}
public void setKd(double kd) {
	this.kd = kd;
}
public double getN() {
	return n;
}
public void setN(double n) {
	this.n = n;
}

public double getKt() {
	return kt;
}
public void setKt(double kt) {
	this.kt = kt;
}
public double getKr() {
	return kr;
}
public void setKr(double kr) {
	this.kr = kr;
}
// ***************** Administration  ******************** // 
@Override
public String toString() {
	return "Material [ks=" + ks + ", kd=" + kd + ", n=" + n + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(kd);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(ks);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(n);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Material other = (Material) obj;
	if (Double.doubleToLongBits(kd) != Double.doubleToLongBits(other.kd))
		return false;
	if (Double.doubleToLongBits(ks) != Double.doubleToLongBits(other.ks))
		return false;
	if (Double.doubleToLongBits(n) != Double.doubleToLongBits(other.n))
		return false;
	return true;
}

}
