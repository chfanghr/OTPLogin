package site.urandom.otplogin.models.serializers;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import site.urandom.otplogin.models.PlayerApproved;
import site.urandom.otplogin.models.VerificationRequired;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class VerificationRequiredDataType implements PersistentDataType<byte[], VerificationRequired> {
    public static VerificationRequiredDataType getInstance() {
        return instance;
    }

    public static VerificationRequiredDataType instance = new VerificationRequiredDataType();


    @NotNull
    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @NotNull
    @Override
    public Class<VerificationRequired> getComplexType() {
        return VerificationRequired.class;
    }

    @NotNull
    @Override
    public byte[] toPrimitive(@NotNull VerificationRequired complex, @NotNull PersistentDataAdapterContext context) {
        return SerializationUtils.serialize(complex);
    }

    @NotNull
    @Override
    public VerificationRequired fromPrimitive(@NotNull byte[] primitive, @NotNull PersistentDataAdapterContext context) {
        try {
            InputStream is = new ByteArrayInputStream(primitive);
            ObjectInputStream ois = new ObjectInputStream(is);
            return (VerificationRequired) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
