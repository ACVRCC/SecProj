package calculator;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
/*Trabalho executado por Alberto Centeno e Sérgio Moutinho*/

@Named
@ApplicationScoped
public class Statistic implements Serializable {

	private static final long serialVersionUID = 1L;
	private int countPlus = 0;
	private int countMinus = 0;
	private int countTimes = 0;
	private int countDivide = 0;
	private int countSin = 0;
	private int countCos = 0;
	private int countTan = 0;
	private int countASin = 0;
	private int countACos = 0;
	private int countATan = 0;
	private int countSqrt = 0;
	private int countCbrt = 0;
	private int countSqr = 0;
	private int countPow = 0;
	private int countAbs = 0;
	private int countExp = 0;
	private int countLog = 0;
	private int countFactorial=0;

	public void countOperator(String operator) {

		switch (operator) {

		case "plus":
			countPlus++;break;
		case "minus":
			countMinus++;break;
		case "times":
			countTimes++;break;
		case "divide":
			countDivide++;break;
		case "sin":
			countSin++;break;
		case "cos":
			countCos++;break;
		case "tan":
			countTan++;break;
		case "Invsin":
			countASin++;break;
		case "InvCos":
			countACos++;break;
		case "InvTan":
			countATan++;break;
		case "sqrt":
			countSqrt++;break;
		case "cubicRoot":
			countCbrt++;break;
		case "sqr":
			countSqr++;break;
		case "pow":
			countPow++;break;
		case "absolute":
			countAbs++;break;
		case "exp":
			countExp++;break;
		case "log":
			countLog++;break;
		case "sind":
			countSin++;break;
		case "cosd":
			countCos++;break;
		case "tand":
			countTan++;break;
		case "asind":
			countASin++;break;
		case "acosd":
			countACos++;break;
		case "atand":
			countATan++;break;
		case "factorial":
			countFactorial++;break;
		}
	}

	public int getCountPlus() {
		return this.countPlus;
	}

	public void setCountPlus(int countPlus) {
		this.countPlus = countPlus;
	}

	public int getCountMinus() {
		return countMinus;
	}

	public void setCountMinus(int countMinus) {
		this.countMinus = countMinus;
	}

	public int getCountTimes() {
		return countTimes;
	}

	public void setCountTimes(int countTimes) {
		this.countTimes = countTimes;
	}

	public int getCountDivide() {
		return countDivide;
	}

	public void setCountDivide(int countDivide) {
		this.countDivide = countDivide;
	}

	public int getCountSin() {
		return this.countSin;
	}

	public void setCountSin(int countSin) {
		this.countSin = countSin;
	}

	public int getCountCos() {
		return this.countCos;
	}

	public void setCountCos(int countCos) {
		this.countCos = countCos;
	}

	public int getCountTan() {
		return this.countTan;
	}

	public void setCountTan(int countTan) {
		this.countTan = countTan;
	}

	public int getCountASin() {
		return this.countASin;
	}

	public void setCountASin(int countASin) {
		this.countASin = countASin;
	}

	public int getCountACos() {
		return this.countACos;
	}

	public void setCountACos(int countACos) {
		this.countACos = countACos;
	}

	public int getCountATan() {
		return this.countATan;
	}

	public void setCountAtan(int countAtan) {
		this.countATan = countAtan;
	}

	public int getCountSqrt() {
		return this.countSqrt;
	}

	public void setCountSqrt(int countSqrt) {
		this.countSqrt = countSqrt;
	}

	public int getCountCbrt() {
		return this.countCbrt;
	}

	public void setCountCbrt(int countCbrt) {
		this.countCbrt = countCbrt;
	}

	public int getCountSqr() {
		return this.countSqr;
	}

	public void setCountSqr(int countSqr) {
		this.countSqr = countSqr;
	}

	public int getCountPow() {
		return this.countPow;
	}

	public void setCountPow(int countPow) {
		this.countPow = countPow;
	}

	public int getCountAbs() {
		return this.countAbs;
	}

	public void setCountAbs(int countAbs) {
		this.countAbs = countAbs;
	}

	public int getCountExp() {
		return this.countExp;
	}

	public void setCountExp(int countExp) {
		this.countExp = countExp;
	}

	public int getCountLog() {
		return this.countLog;
	}

	public void setCountLog(int countLog) {
		this.countLog = countLog;
	}
	public int getCountFactorial() {
		return this.countFactorial;
	}

	public void setCountFactorial(int countFactorial) {
		this.countFactorial = countFactorial;
	}
}