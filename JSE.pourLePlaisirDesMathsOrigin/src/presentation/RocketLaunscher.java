package presentation;

import metier.Complexe;
import metier.Reel;
import service.ComplexeService;
import service.IComplexeService;
import service.IReelService;
import service.ReelService;

public class RocketLaunscher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// décla interface
		IReelService rRes = new ReelService();
		IComplexeService cRes = new ComplexeService();

		Reel rx = new Reel(10);
		Reel ry = new Reel(20);
		Complexe cx = new Complexe(10, 5);
		Complexe cy = new Complexe(20, 10);

		System.out.println("addition rx = " + rx.getReel() + " + ry = " + ry.getReel());
		System.out.println(rRes.addition(rx, ry));
		System.out.println(
				"addition cx = Re " + cx.getRe() + " Im " + cx.getIm() + " + cy = Re " + cy.getRe() + " Im " + cy.getIm());
		System.out.println(cRes.addition(cx, cy));
		
		System.out.println("soustraction rx = " + rx.getReel() + " - ry = " + ry.getReel());
		System.out.println(rRes.soustraction(rx, ry));
		System.out.println(
				"soustraction cx = Re " + cx.getRe() + " Im " + cx.getIm() + " - cy = Re " + cy.getRe() + " Im " + cy.getIm());
		System.out.println(cRes.soustraction(cx, cy));
	}

}
