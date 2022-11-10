def XOR (mensaje,clave):
    for i in range(len(mensaje)):
        aux_clave = clave[i%len(clave)]
        mensaje = (mensaje[:i] +
        chr(ord(mensaje[i]) ^ ord(aux_clave)) + mensaje[i + 1:]);
    return mensaje;

mensaje = '+*5-=;¡.61!47=?9;;;.'
clave = 'XOR'
respuesta = XOR(mensaje,clave)
print(mensaje, respuesta)