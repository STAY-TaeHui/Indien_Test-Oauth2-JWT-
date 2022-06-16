package com.indien.indien_backend.domain.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberDetail is a Querydsl query type for MemberDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberDetail extends EntityPathBase<MemberDetail> {

    private static final long serialVersionUID = 526806605L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberDetail memberDetail = new QMemberDetail("memberDetail");

    public final StringPath backgroundImg = createString("backgroundImg");

    public final BooleanPath followerBlindCheck = createBoolean("followerBlindCheck");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath intro = createString("intro");

    public final QMember member;

    public final StringPath nick = createString("nick");

    public final BooleanPath notifyCheck = createBoolean("notifyCheck");

    public final BooleanPath privateCheck = createBoolean("privateCheck");

    public final StringPath profileImg = createString("profileImg");

    public final BooleanPath snsUseCheck = createBoolean("snsUseCheck");

    public QMemberDetail(String variable) {
        this(MemberDetail.class, forVariable(variable), INITS);
    }

    public QMemberDetail(Path<? extends MemberDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberDetail(PathMetadata metadata, PathInits inits) {
        this(MemberDetail.class, metadata, inits);
    }

    public QMemberDetail(Class<? extends MemberDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

