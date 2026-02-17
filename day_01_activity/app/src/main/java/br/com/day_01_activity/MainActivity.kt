package br.com.day_01_activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Declaração da classe MainActivity: É a tela principal do app.
// AppCompatActivity: É a Activity base com suporte a recursos de compatibilidade.
class MainActivity : AppCompatActivity() {

    // onCreate: É o método chamado automaticamente quando a Activity é iniciada.
    // saveInstanceState: guarda estado anterior da tela
    // ex: rotação de tela (activity destruida e recriada), falta de memória, mudança de idioma.
    // Bundle: É um Map<chave, valor>, otimizado para Android. Usado para transportar dados entre componentes.
    override fun onCreate(savedInstanceState: Bundle?) {

        // Super: Chamada a implementação da superClasse (super). Obrigatorio para o cliclo de vida funcionar corretamente.
        super.onCreate(savedInstanceState)
        // Ativa o modo "Edge-To-Edge", perimitindo que o layout ocupe a tela inteira, por trás dda Status bar e navigation bar.
        // TODO: enableEdgeToEdge()
        enableEdgeToEdge()
        // setContentView: Infla o layout XML no código, que será usado como interface dessa Activity.
        // R.layout.activity_main -> arquivo res/layout/activity_main.xml
        setContentView(R.layout.activity_main)
        // Procura a View com o id "main" no layout e aplica um listener de Insets (área do sistema).
        // Insets: Área ocupada por barras do sistema (status bar, navigation bar, que  recortes, etc).
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // systemBars: Obtém o tamanho das áreas ocupadas pelas as barras do sistema.

            // TODO: setOnApplyWindowInsetsListener: escuta quando os insets da janela são aplicados.
            // set: (definir/configurar)
            // OnApply: (Quando for aplicar)
            // WindowInsets: (Areas da janela ocupadas pelo sistema)
            // Listener (ouvinte/observador do evento)

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Ajusta o padding da View para não ficar escondido atrás das barras do sistema.
            // left, top, rigth, bottom -> margens intenas aplicadas dinamicamente.
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            // Retorna os insets depois de aplicados.
            insets
        }
    }
}