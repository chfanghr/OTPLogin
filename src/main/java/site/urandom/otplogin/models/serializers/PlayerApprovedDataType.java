package site.urandom.otplogin.models.serializers;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import site.urandom.otplogin.models.LoginSecret;
import site.urandom.otplogin.models.PlayerApproved;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class PlayerApprovedDataType implements PersistentDataType<byte[], PlayerApproved> {
    public static PlayerApprovedDataType getInstance() {
        return instance;
    }

    public static final PlayerApprovedDataType instance = new PlayerApprovedDataType();

    @NotNull
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @NotNull
    @Override
    public Class<PlayerApproved> getComplexType() {
        return PlayerApproved.class;
    }

    @NotNull
    @Override
    public byte[] toPrimitive(@NotNull PlayerApproved complex, @NotNull PersistentDataAdapterContext context) {
        return SerializationUtils.serialize(complex);
    }

    @NotNull
    @Override
    public PlayerApproved fromPrimitive(@NotNull byte[] primitive, @NotNull PersistentDataAdapterContext context) {
        try {
            InputStream is = new ByteArrayInputStream(primitive);
            ObjectInputStream ois = new ObjectInputStream(is);
            return (PlayerApproved) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
