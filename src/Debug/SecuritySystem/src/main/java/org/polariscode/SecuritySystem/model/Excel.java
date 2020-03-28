package org.polariscode.SecuritySystem.model;

import java.io.Serializable;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.polariscode.SecuritySystem.service.DictionaryService;
import org.polariscode.SecuritySystem.model.DictionaryItem;

@Component
public class Excel implements Serializable {
	@Autowired
	private DictionaryService dictionaryService;

	private static Excel m_Excel;

	@PostConstruct 
	public void init(){
		m_Excel=this;
		m_Excel.dictionaryService=this.dictionaryService;
	}

	private String A = "";
	public String getA(){
		return this.A;
	}
	public void setA(String value){
		this.A = value;
	}

	private String B = "";
	public String getB(){
		return this.B;
	}
	public void setB(String value){
		this.B = value;
	}

	private String C = "";
	public String getC(){
		return this.C;
	}
	public void setC(String value){
		this.C = value;
	}

	private String D = "";
	public String getD(){
		return this.D;
	}
	public void setD(String value){
		this.D = value;
	}

	private String E = "";
	public String getE(){
		return this.E;
	}
	public void setE(String value){
		this.E = value;
	}

	private String F = "";
	public String getF(){
		return this.F;
	}
	public void setF(String value){
		this.F = value;
	}

	private String G = "";
	public String getG(){
		return this.G;
	}
	public void setG(String value){
		this.G = value;
	}

	private String H = "";
	public String getH(){
		return this.H;
	}
	public void setH(String value){
		this.H = value;
	}

	private String I = "";
	public String getI(){
		return this.I;
	}
	public void setI(String value){
		this.I = value;
	}

	private String J = "";
	public String getJ(){
		return this.J;
	}
	public void setJ(String value){
		this.J = value;
	}

	private String K = "";
	public String getK(){
		return this.K;
	}
	public void setK(String value){
		this.K = value;
	}

	private String L = "";
	public String getL(){
		return this.L;
	}
	public void setL(String value){
		this.L = value;
	}

	private String M = "";
	public String getM(){
		return this.M;
	}
	public void setM(String value){
		this.M = value;
	}

	private String N = "";
	public String getN(){
		return this.N;
	}
	public void setN(String value){
		this.N = value;
	}

	private String O = "";
	public String getO(){
		return this.O;
	}
	public void setO(String value){
		this.O = value;
	}

	private String P = "";
	public String getP(){
		return this.P;
	}
	public void setP(String value){
		this.P = value;
	}

	private String Q = "";
	public String getQ(){
		return this.Q;
	}
	public void setQ(String value){
		this.Q = value;
	}

	private String R = "";
	public String getR(){
		return this.R;
	}
	public void setR(String value){
		this.R = value;
	}

	private String S = "";
	public String getS(){
		return this.S;
	}
	public void setS(String value){
		this.S = value;
	}

	private String T = "";
	public String getT(){
		return this.T;
	}
	public void setT(String value){
		this.T = value;
	}

	private String U = "";
	public String getU(){
		return this.U;
	}
	public void setU(String value){
		this.U = value;
	}

	private String V = "";
	public String getV(){
		return this.V;
	}
	public void setV(String value){
		this.V = value;
	}

	private String W = "";
	public String getW(){
		return this.W;
	}
	public void setW(String value){
		this.W = value;
	}

	private String X = "";
	public String getX(){
		return this.X;
	}
	public void setX(String value){
		this.X = value;
	}

	private String Y = "";
	public String getY(){
		return this.Y;
	}
	public void setY(String value){
		this.Y = value;
	}

	private String Z = "";
	public String getZ(){
		return this.Z;
	}
	public void setZ(String value){
		this.Z = value;
	}

	private String AA = "";
	public String getAA(){
		return this.AA;
	}
	public void setAA(String value){
		this.AA = value;
	}

	private String AB = "";
	public String getAB(){
		return this.AB;
	}
	public void setAB(String value){
		this.AB = value;
	}

	private String AC = "";
	public String getAC(){
		return this.AC;
	}
	public void setAC(String value){
		this.AC = value;
	}

	private String AD = "";
	public String getAD(){
		return this.AD;
	}
	public void setAD(String value){
		this.AD = value;
	}

	private String AE = "";
	public String getAE(){
		return this.AE;
	}
	public void setAE(String value){
		this.AE = value;
	}

	private String AF = "";
	public String getAF(){
		return this.AF;
	}
	public void setAF(String value){
		this.AF = value;
	}

	private String AG = "";
	public String getAG(){
		return this.AG;
	}
	public void setAG(String value){
		this.AG = value;
	}

	private String AH = "";
	public String getAH(){
		return this.AH;
	}
	public void setAH(String value){
		this.AH = value;
	}

	private String AI = "";
	public String getAI(){
		return this.AI;
	}
	public void setAI(String value){
		this.AI = value;
	}

	private String AJ = "";
	public String getAJ(){
		return this.AJ;
	}
	public void setAJ(String value){
		this.AJ = value;
	}

	private String AK = "";
	public String getAK(){
		return this.AK;
	}
	public void setAK(String value){
		this.AK = value;
	}

	private String AL = "";
	public String getAL(){
		return this.AL;
	}
	public void setAL(String value){
		this.AL = value;
	}

	private String AM = "";
	public String getAM(){
		return this.AM;
	}
	public void setAM(String value){
		this.AM = value;
	}

	private String AN = "";
	public String getAN(){
		return this.AN;
	}
	public void setAN(String value){
		this.AN = value;
	}

	private String AO = "";
	public String getAO(){
		return this.AO;
	}
	public void setAO(String value){
		this.AO = value;
	}

	private String AP = "";
	public String getAP(){
		return this.AP;
	}
	public void setAP(String value){
		this.AP = value;
	}

	private String AQ = "";
	public String getAQ(){
		return this.AQ;
	}
	public void setAQ(String value){
		this.AQ = value;
	}

	private String AR = "";
	public String getAR(){
		return this.AR;
	}
	public void setAR(String value){
		this.AR = value;
	}

	private String AS = "";
	public String getAS(){
		return this.AS;
	}
	public void setAS(String value){
		this.AS = value;
	}

	private String AT = "";
	public String getAT(){
		return this.AT;
	}
	public void setAT(String value){
		this.AT = value;
	}

	private String AU = "";
	public String getAU(){
		return this.AU;
	}
	public void setAU(String value){
		this.AU = value;
	}

	private String AV = "";
	public String getAV(){
		return this.AV;
	}
	public void setAV(String value){
		this.AV = value;
	}

	private String AW = "";
	public String getAW(){
		return this.AW;
	}
	public void setAW(String value){
		this.AW = value;
	}

	private String AX = "";
	public String getAX(){
		return this.AX;
	}
	public void setAX(String value){
		this.AX = value;
	}

	private String AY = "";
	public String getAY(){
		return this.AY;
	}
	public void setAY(String value){
		this.AY = value;
	}

	private String AZ = "";
	public String getAZ(){
		return this.AZ;
	}
	public void setAZ(String value){
		this.AZ = value;
	}

}
