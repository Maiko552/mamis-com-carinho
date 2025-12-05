package br.com.maikonspo.mamiscomcarinho.core.entities.pedido;

public enum Cores {
    AMARELO("Amarelo", "#FFFF00"),
    AMARELO_CLARO("Amarelo Claro", "#FFF9A6"),
    AMARELO_ESCURO("Amarelo Escuro", "#E6C300"),
    DOURADO("Dourado", "#FFD700"),
    LARANJA("Laranja", "#FFA500"),
    LARANJA_CLARO("Laranja Claro", "#FFC966"),
    LARANJA_ESCURO("Laranja Escuro", "#FF8C00"),
    PESSEGO("Pêssego", "#FFDAB9"),
    SALMAO("Salmão", "#FA8072"),
    VERMELHO("Vermelho", "#FF0000"),
    VERMELHO_ESCURO("Vermelho Escuro", "#8B0000"),
    BORDO("Bordô", "#800000"),
    VINHO("Vinho", "#6B0F1A"),
    ROSA("Rosa", "#FFC0CB"),
    ROSA_CLARO("Rosa Claro", "#FFD6E7"),
    ROSA_CHOQUE("Rosa Choque", "#FF1493"),
    MAGENTA("Magenta", "#FF00FF"),
    ROXO("Roxo", "#800080"),
    LILAS("Lilás", "#C8A2C8"),
    AZUL("Azul", "#0000FF"),
    AZUL_CLARO("Azul Claro", "#87CEFA"),
    AZUL_BEBE("Azul Bebê", "#BFEFFF"),
    AZUL_CELESTE("Azul Celeste", "#00BFFF"),
    AZUL_TURQUESA("Azul Turquesa", "#40E0D0"),
    AZUL_PETROLEO("Azul Petróleo", "#004953"),
    AZUL_ESCURO("Azul Escuro", "#00008B"),
    AZUL_MARINHO("Azul Marinho", "#000080"),
    CIANO("Ciano", "#00FFFF"),
    VERDE("Verde", "#008000"),
    VERDE_CLARO("Verde Claro", "#90EE90"),
    VERDE_LIMAO("Verde Limão", "#32CD32"),
    VERDE_MENTA("Verde Menta", "#98FF98"),
    VERDE_ESCURO("Verde Escuro", "#006400"),
    VERDE_MUSGO("Verde Musgo", "#556B2F"),
    VERDE_AGUA("Verde Água", "#20B2AA"),
    MARROM("Marrom", "#8B4513"),
    MARROM_CLARO("Marrom Claro", "#CD853F"),
    CARAMELO("Caramelo", "#A0522D"),
    BEGE("Bege", "#F5F5DC"),
    CREME("Creme", "#FFFDD0"),
    PRETO("Preto", "#000000"),
    BRANCO("Branco", "#FFFFFF"),
    CINZA("Cinza", "#808080"),
    CINZA_CLARO("Cinza Claro", "#D3D3D3"),
    CINZA_ESCURO("Cinza Escuro", "#A9A9A9"),
    PRATA("Prata", "#C0C0C0"),
    BRONZE("Bronze", "#CD7F32");

    private final String descricao;
    private final String hex;

    Cores(String descricao, String hex) {
        this.descricao = descricao;
        this.hex = hex;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getHex() {
        return hex;
    }
}
