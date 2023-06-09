package com.tienda.online.dao.file.merchant;


import com.tienda.online.dao.file.compartido.DeSerializer;
import com.tienda.online.dao.modelo.Merchant;

public class MerchantDeSerializer implements DeSerializer {

	@Override
	public Object deSerializar(String linea) {
		
		final String SEPARATOR = ",";
		
		String[] attributosMerchant = linea.split(SEPARATOR);
		
		Merchant merchant = new Merchant();
		
		merchant.setId(attributosMerchant[0]);
		merchant.setNombre(attributosMerchant[1]);
		merchant.setTipoNegocio(attributosMerchant[2]);
		
		return merchant;
	}

}
