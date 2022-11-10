import base64

mensaje = "RWplcmNpY2lvQmFzZTY0UmVzdWVsdG8="
accion = input("cifrar/descifrar: ")

if accion == 'cifrar':
    mensaje = mensaje.encode('ascii')
    mensaje = base64.b64encode(mensaje)
    mensaje = mensaje.decode('ascii')
elif accion == 'descifrar':
    mensaje = mensaje.encode('ascii')
    mensaje = base64.b64decode(mensaje)
    mensaje = mensaje.decode('ascii')

print(mensaje)
