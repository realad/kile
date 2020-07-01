const kile_core = require("kile/packages/kile-core")
const kile_adapters_ftp = require("kile/packages/kile-adapters-ftp")

let connection = new kile_core.io.realad.kile.Kile(
    new kile_adapters_ftp.io.realad.kile.adapters.ftp.FtpAdapter(
        new kile_adapters_ftp.io.realad.kile.adapters.ftp.FtpConnectionOptions("localhost"),
        new kile_adapters_ftp.io.realad.kile.adapters.ftp.FtpConnectionProvider()
    )
);

let result = connection.fileExists("/")
