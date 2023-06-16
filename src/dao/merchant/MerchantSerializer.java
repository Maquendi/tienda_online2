package dao.merchant;

import dao.compartido.Serializador;
import dao.modelo.Merchant;

public class MerchantSerializer implements Serializador{

	private final Merchant merchant;
	
	public MerchantSerializer(Merchant merchant) {
		this.merchant = merchant;
	}
	
	@Override
	public String serializar() {
		
		final var SEPARATOR = ",";
		
		var merchantStringBuilder = new StringBuilder();
		
		return merchantStringBuilder
				.append(merchant.getId())
				.append(SEPARATOR)
				.append(merchant.getNombre())
				.append(SEPARATOR)
				.append(merchant.getTipoNegocio())
				.toString();
		

	}

}
