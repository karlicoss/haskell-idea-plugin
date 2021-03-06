package org.jetbrains.haskell.psi

import com.intellij.lang.ASTNode
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.tree.TokenSet
import org.jetbrains.haskell.parser.token.*
import org.jetbrains.grammar.HaskellLexerTokens


public class Import(node : ASTNode) : ASTWrapperPsiElement(node) {

    public fun hasHiding() : Boolean {
        return getNode().getChildren(TokenSet.create(HaskellLexerTokens.HIDING))!!.size > 0
    }

    public fun getModuleName() : ModuleName? =
        findChildByClass(javaClass<ModuleName>())


    public fun getModuleExports() : ModuleExports? =
        findChildByClass(javaClass<ModuleExports>())

    public fun getImportAsPart() : ImportAsPart? =
            findChildByClass(javaClass<ImportAsPart>())

    public fun findModule() : Module? = getModuleName()?.findModuleFile()?.getModule()
}