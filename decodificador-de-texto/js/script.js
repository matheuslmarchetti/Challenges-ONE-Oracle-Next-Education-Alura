const textArea = document.querySelector(".text-area");
const mensagem = document.querySelector(".mensagem");

// As "chaves" de criptografia que utilizaremos são:
// `A letra "e" é convertida para "enter"`
// `A letra "i" é convertida para "imes"`
// `A letra "a" é convertida para "ai"`
// `A letra "o" é convertida para "ober"`
// `A letra "u" é convertida para "ufat"`

function btnEncriptar() {
    if (textArea.value === "") {
        mensagem.style.backgroundImage="url('https://raw.githubusercontent.com/matheuslmarchetti/Challenges-ONE-Oracle-Next-Education-Alura/5347ee77361b9c05023706cc548091722a8a4515/decodificador-de-texto/images/boneco.svg')";
        mensagem.readOnly = true;
        mensagem.value = "";
    } else {
        const textoEncriptado = encriptar(textArea.value);
        mensagem.style.backgroundImage='none';
        mensagem.readOnly = true;
        mensagem.value = textoEncriptado;
        textArea.value = "";   
    }
}


function encriptar(stringEncriptada) {

    let matrizCodigo = [["e" , "enter"] , ["i" , "imes"], ["a" ,"ai"] , ["o" , "ober"], ["u" , "ufat"]];
    stringEncriptada = stringEncriptada.toLowerCase();

    for(let i = 0; i < matrizCodigo.length; i++) {
        if(stringEncriptada.includes(matrizCodigo[i][0])) {
            stringEncriptada = stringEncriptada.replaceAll(matrizCodigo[i][0], matrizCodigo[i][1]);
        }
    }

    return stringEncriptada;
}


function btnDesencriptar() {
    if (textArea.value === "") {
        mensagem.style.backgroundImage="url('https://raw.githubusercontent.com/matheuslmarchetti/Challenges-ONE-Oracle-Next-Education-Alura/5347ee77361b9c05023706cc548091722a8a4515/decodificador-de-texto/images/boneco.svg')";
        mensagem.readOnly = true;
        mensagem.value = "";
    } else {
        const textoDesencriptado = desencriptar(textArea.value);
        mensagem.style.backgroundImage='none';
        mensagem.readOnly = true;
        mensagem.value = textoDesencriptado;
        textArea.value = "";
    }
}


function desencriptar(stringDesencriptada) {

    let matrizCodigo = [["e" , "enter"] , ["i" , "imes"], ["a" ,"ai"] , ["o" , "ober"], ["u" , "ufat"]];
    stringDesencriptada = stringDesencriptada.toLowerCase();

    for(let i = 0; i < matrizCodigo.length; i++) {
        if(stringDesencriptada.includes(matrizCodigo[i][1])) {
            stringDesencriptada = stringDesencriptada.replaceAll(matrizCodigo[i][1], matrizCodigo[i][0]);
        }
    }

    return stringDesencriptada;
}

function btnCopiar() {
    mensagem.select();
    mensagem.setSelectionRange(0, 99999)
    navigator.clipboard.writeText(mensagem.value);
}