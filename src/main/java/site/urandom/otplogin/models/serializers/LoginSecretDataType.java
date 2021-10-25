package site.urandom.otplogin.models.serializers;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import site.urandom.otplogin.models.LoginSecret;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class LoginSecretDataType implements PersistentDataType<byte[], LoginSecret> {
    public static LoginSecretDataType getInstance() {
        return instance;
    }

    private static final LoginSecretDataType instance = new LoginSecretDataType();

    @NotNull
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @NotNull
    @Override
    public Class<LoginSecret> getComplexType() {
        return LoginSecret.class;
    }

    @Override
    public byte[] toPrimitive(@NotNull LoginSecret complex, @NotNull PersistentDataAdapterContext context) {
        return SerializationUtils.serialize(complex);
    }

    @Override
    public LoginSecret fromPrimitive(byte[] primitive, @NotNull PersistentDataAdapterContext context) {
        try {
            InputStream is = new ByteArrayInputStream(primitive);
            ObjectInputStream ois = new ObjectInputStream(is);
            return (LoginSecret) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
