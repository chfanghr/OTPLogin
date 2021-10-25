package site.urandom.otplogin.models;

import com.bastiaanjansen.otp.HMACAlgorithm;
import com.bastiaanjansen.otp.SecretGenerator;
import com.bastiaanjansen.otp.TOTPGenerator;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.Serializable;

public class LoginSecret implements Serializable {
    private static final String persistentKey = LoginSecret.class.getName();

    public static NamespacedKey getPersistentKey(JavaPlugin plugin){
        return new NamespacedKey(plugin, persistentKey);
    }
    private static final long serialVersionUID = 1;

    private static final HMACAlgorithm tOtpAlgorithm = HMACAlgorithm.SHA256;

    public byte[] secret;

    public LoginSecret(){
        secret = SecretGenerator.generate();
    }

    public TOTPGenerator getTOTPGenerator(){
        TOTPGenerator.Builder builder = new TOTPGenerator.Builder(secret);
        builder.withAlgorithm(tOtpAlgorithm);
        return builder.build();
    }


}
