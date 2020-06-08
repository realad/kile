package io.realad.kile.adapters.ftp

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import org.apache.commons.net.ftp.FTPClient
import org.mockftpserver.fake.FakeFtpServer
import org.mockftpserver.fake.UserAccount
import org.mockftpserver.fake.filesystem.DirectoryEntry
import org.mockftpserver.fake.filesystem.FileEntry
import org.mockftpserver.fake.filesystem.UnixFakeFileSystem

class ApacheFtpConnectionTest : StringSpec({

    val username = "wasya"
    val password = "qwerty"
    val homeDirectory = "/home/$username/secure/credit_card"
    lateinit var fakeFtpServer: FakeFtpServer
    val ftpClient by lazy {
        val ftpClient = FTPClient()
        ftpClient.connect("localhost", fakeFtpServer.serverControlPort)
        ftpClient.login(username, password)
        return@lazy ftpClient
    }

    beforeSpec {
        fakeFtpServer = FakeFtpServer().apply {
            serverControlPort = 1234
            addUserAccount(UserAccount(username, password, homeDirectory))
            fileSystem = UnixFakeFileSystem().apply {
                add(DirectoryEntry(homeDirectory))
                add(FileEntry("$homeDirectory/pin.txt", "my new pin code from primary credit card is 0000"))
                add(FileEntry("$homeDirectory/number.txt", "my credit card number is 0000 9999 8888 7777"))
                add(FileEntry("$homeDirectory/cvv.txt", "my credit card cvv code is 777"))
            }
        }
        fakeFtpServer.start()
    }

    "should return a list of files" {
        val connection = ApacheFtpConnection(ftpClient)
        val result = connection.mlistDir(homeDirectory)
        result shouldContainExactly listOf("pin.txt", "number.txt", "cvv.txt")
    }

    afterSpec {
        fakeFtpServer.stop()
    }

})
