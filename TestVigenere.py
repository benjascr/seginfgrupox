def descifrar(clave,mensaje,Alfabeto):
    respuesta = []
    posicion = 0

    for caracter in mensaje:
        numero = Alfabeto.find(caracter)
        if numero!=-1:
            numero = numero - Alfabeto.find(clave[posicion])
            numero %= len(Alfabeto)
            respuesta.append(Alfabeto[numero])
            posicion = posicion + 1
            if posicion == len(clave):
                posicion = 0
        else:
            respuesta.append(caracter)
    return respuesta

def cifrar(clave,mensaje,Alfabeto):
    respuesta = []
    posicion = 0

    for caracter in mensaje:
        numero = Alfabeto.find(caracter)
        if numero!=-1:
            numero = numero + Alfabeto.find(clave[posicion])
            numero %= len(Alfabeto)
            respuesta.append(Alfabeto[numero])
            posicion = posicion + 1
            if posicion == len(clave):
                posicion = 0
        else:
            respuesta.append(caracter)
    return respuesta
            
Alfabeto = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")
mensaje = "QqmiaiiiYmisqmwmxijs"
clave = "Vigenere"

accion = input("cifrar/descifrar: ")
if accion == 'cifrar':
    traducido = cifrar(clave,mensaje,Alfabeto)
elif accion == 'descifrar':
    traducido = descifrar(clave,mensaje,Alfabeto)

print(traducido)


