package com.indien.indien_backend.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -562888996L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMember member = new QMember("member1");

    public final EnumPath<com.indien.indien_backend.domain.common.Authority> authority = createEnum("authority", com.indien.indien_backend.domain.common.Authority.class);

    public final DateTimePath<java.time.Instant> created = createDateTime("created", java.time.Instant.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMemberDetail memberDetail;

    public final StringPath passwd = createString("passwd");

    public final DateTimePath<java.time.Instant> updated = createDateTime("updated", java.time.Instant.class);

    public QMember(String variable) {
        this(Member.class, forVariable(variable), INITS);
    }

    public QMember(Path<? extends Member> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMember(PathMetadata metadata, PathInits inits) {
        this(Member.class, metadata, inits);
    }

    public QMember(Class<? extends Member> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberDetail = inits.isInitialized("memberDetail") ? new QMemberDetail(forProperty("memberDetail"), inits.get("memberDetail")) : null;
    }

}

