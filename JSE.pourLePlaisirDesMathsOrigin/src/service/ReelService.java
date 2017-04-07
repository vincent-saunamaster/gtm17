package service;

import metier.Reel;

public class ReelService implements IReelService {

	@Override
	public Reel addition(Reel x, Reel y) {
		// TODO Auto-generated method stub
		Reel r = new Reel(x.getReel() + y.getReel());
		return r;
	}

	@Override
	public Reel soustraction(Reel x, Reel y) {
		// TODO Auto-generated method stub
		Reel r = new Reel(x.getReel() - y.getReel());
		return r;
	}

}
