package com.example.desafio_android_kotlin.ui.recyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.desafio_android_kotlin.Model.Character
import com.example.desafio_android_kotlin.R
import com.example.desafio_android_kotlin.databinding.ItemMainBinding

class ListaProdutosAdapter(
    products : List<Character> = emptyList()
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val characters = products.toMutableList()

    class ViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun vincula(character: Character) {
            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, CharacterDetailsActivity::class.java)
                binding.root.context.startActivity(intent)
            }
            val nome = binding.nomeItem
            nome.text = character.nome
            val descricao = binding.descricaoItem
            descricao.text = character.descricao
            val outro = binding.outroItem
            outro.text = character.outro

            if(character.img==null) {
                binding.imageItem.visibility = View.GONE
                /*binding.nome.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    startToStart = R.id.produto_constraint
                    }
                */
            }
            else {
                binding.imageItem.visibility = View.VISIBLE
            }

            binding.imageItem.load(character.img) {
                fallback(R.drawable.mystery_character)
                error(R.drawable.mystery_character)
                placeholder(R.drawable.loading)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = characters[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = characters.size

    fun atualiza(products: List<Character>) {
        this.characters.clear()
        this.characters.addAll(products)
        notifyDataSetChanged()
    }

}
