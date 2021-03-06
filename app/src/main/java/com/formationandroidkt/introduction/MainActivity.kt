package com.formationandroidkt.introduction

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity()
{

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	/**
	 * Listener clic bouton calculer.
	 */
	@Suppress("UNUSED_PARAMETER")
	fun clicCalculer(view: View)
	{
		// commande :
		val commande = edittext_commande.text.toString()

		// éléments de la commande :
		val elements = commande.split(" ")

		// vérification préalable :
		if (elements.size < 2)
		{
			Toast.makeText(this, R.string.main_commande_invalide, Toast.LENGTH_LONG).show()
			return
		}

		// cas :
		var total = 0
		try
		{
			when (elements[0])
			{
				"somme" ->
				{
					total = 0
					elements.takeLast(elements.size - 1).forEach {
						total += it.toInt()
					}
				}
				"diff" ->
				{
					total = elements[1].toInt()
					elements.takeLast(elements.size - 2).forEach {
						total -= it.toInt()
					}
				}
				"mult" ->
				{
					total = 1
					elements.takeLast(elements.size - 1).forEach {
						total *= it.toInt()
					}
				}
				"div" ->
				{
					total = elements[1].toInt()
					elements.takeLast(elements.size - 2).forEach {
						total /= it.toInt()
					}
				}
				else ->
				{
					Toast.makeText(this, R.string.main_commande_invalide, Toast.LENGTH_LONG).show()
					return
				}
			}
		}
		catch (e: Exception)
		{
			Toast.makeText(this, R.string.main_commande_invalide, Toast.LENGTH_LONG).show()
			return
		}

		// résultat :
		Toast.makeText(this, getString(R.string.main_resultat, total), Toast.LENGTH_LONG).show()
	}

}
