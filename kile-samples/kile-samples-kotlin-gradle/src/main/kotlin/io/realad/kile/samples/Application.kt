package io.realad.kile.samples

import io.realad.kile.Kile
import io.realad.kile.adapters.ftp.FtpAdapter
import io.realad.kile.adapters.ftp.FtpConnectionOptions
import io.realad.kile.adapters.ftp.FtpConnectionProvider

fun main() {
    val kile = Kile(FtpAdapter(FtpConnectionOptions("localhost"), FtpConnectionProvider()))
    val contents = kile.listContents("/")
}
